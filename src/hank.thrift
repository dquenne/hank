namespace java com.rapleaf.hank.generated

union HankException {
  /** The host queried is not assigned the key that was requested */
  1: bool wrong_host;

  /** The domain passed in the request does not correspond to a valid domain */
  2: bool no_such_domain;

  /** There were no available replicas for a given partition */
  3: bool zero_replicas;

  /** There was some internal error in the server. This is pretty bad. */
  4: string internal_error;
}

union HankBulkException {
  /** The domain passed in the request does not correspond to a valid domain */
  1: bool no_such_domain;
}

union HankResponse {
  /* Equivalent to a "null" value */
  1: bool not_found;

  /* If found, binary result */
  2: binary value;

  /* Error states */
  3: HankException xception;
}

union HankBulkResponse {
  /* Individual responses */
  1: list<HankResponse> responses;

  /* Error states */
  2: HankBulkException xception;
}

service PartitionServer {
  HankResponse get(1:i32 domain_id, 2:binary key);
  HankBulkResponse getBulk(1:i32 domain_id, 2:list<binary> keys);
}

service SmartClient {
  HankResponse get(1:string domain_name, 2:binary key);
  HankBulkResponse getBulk(1:string domain_name, 2:list<binary> keys);
}