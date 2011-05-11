package com.rapleaf.hank.ui;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rapleaf.hank.coordinator.Coordinator;
import com.rapleaf.hank.coordinator.DomainConfig;
import com.rapleaf.hank.coordinator.DomainGroupConfig;
import com.rapleaf.hank.coordinator.DomainGroupConfigVersion;

public class DomainGroupController extends HttpServlet {
  private final Coordinator coordinator;

  public DomainGroupController(Coordinator coordinator) {
    this.coordinator = coordinator;
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if (req.getRequestURI().contains("create")) {
      doCreate(req, resp);
    } else if (req.getRequestURI().contains("add_domain")) {
      doAddDomain(req, resp);
    } else if (req.getRequestURI().contains("add_version")) {
      doAddVersion(req, resp);
    } else {
      System.out.println("Bad URI!" + req.getRequestURI());
      resp.sendError(404);
    }
  }

  private void doAddVersion(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String dgName = URLDecoder.decode(req.getParameter("n"));

    DomainGroupConfig dg = coordinator.getDomainGroupConfig(dgName);

    Map<String, Integer> domainVersions = new HashMap<String, Integer>();
    for (DomainConfig domainConfig : dg.getDomainConfigs()) {
      int v = Integer.parseInt(req.getParameter(domainConfig.getName() + "_version"));
      domainVersions.put(domainConfig.getName(), v);
    }
    DomainGroupConfigVersion newVersion = dg.createNewVersion(domainVersions);

    resp.sendRedirect("/domain_group.jsp?n=" + req.getParameter("n"));
  }

  private void doAddDomain(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String dgName = URLDecoder.decode(req.getParameter("n"));
    String dName = URLDecoder.decode(req.getParameter("d"));
    DomainGroupConfig dg = coordinator.getDomainGroupConfig(dgName);
    DomainConfig domainConfig = coordinator.getDomainConfig(dName);

    int domainId = -1;
    for (DomainConfig dc : dg.getDomainConfigs()) {
      int thisDomainId = dg.getDomainId(dc.getName());
      if (thisDomainId > domainId) {
        domainId = thisDomainId;
      }
    }
    domainId++;

    dg.addDomain(domainConfig, domainId);
    resp.sendRedirect("/domain_group.jsp?n=" + req.getParameter("n"));
  }

  private void doCreate(HttpServletRequest req, HttpServletResponse response) throws IOException {
    coordinator.addDomainGroup(req.getParameter("name"));
    response.sendRedirect("/domain_groups.jsp");
  }
}
