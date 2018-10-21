namespace java edu.dair.sgdb.thrift

struct KeyValue {
  1: binary key,
  2: binary value,
}

struct GigaScan {
    1: required list<KeyValue> kvs,
    2: required binary bitmap,
}

struct Movement {
  1: required i32 loc,
  2: required KeyValue kv,
}

exception RedirectException{
    1: required i32 status,
    2: optional i32 target,
    3: optional list<Movement> re,
    4: optional binary bitmap,
}

struct Dist{
  1: required i32 splitNum,
  2: required i32 vertexNum,
}

struct Status{
  1: binary key,
  2: i32 issplit,
  3: i32 location,
}

service TGraphFSServer {
    i32 echo(1:i32 s, 2:binary payload),

    i32 insert(1:binary src, 2:binary dst, 3:i32 type, 4:binary val) throws (1: RedirectException r),
    i32 batch_insert(1:list<KeyValue> batches, 2:i32 type) throws (1: RedirectException r),
    list<Dist> get_state(), //list<Dist> stat_dst(1: Command c),
    list<KeyValue> read(1:binary src, 2:binary dst, 3:i32 type) throws (1: RedirectException r),
    list<KeyValue> scan(1:binary src, 2:i32 type) throws (1: RedirectException r),

    i32 giga_batch_insert(1:binary src, 2:i32 vid, 3:list<KeyValue> batches) throws (1: RedirectException r),
    i32 giga_split(1:binary src, 2:i32 vid, 3:i32 stage, 4:binary bitmap),
    i32 giga_rec_split(1:binary src, 2:i32 vid, 3:list<KeyValue> batches),
    GigaScan giga_scan(1:binary src, 2:i32 type, 3:binary bitmap),

    i32 iogp_batch_insert(1:list<KeyValue> batches, 2:i32 type) throws (1: RedirectException r),
    list<KeyValue> iogp_force_scan(1:binary src, 2:i32 type) throws (1: RedirectException r),
    i32 iogp_split(1:binary src) throws (1: RedirectException r),
    i32 iogp_reassign(1:binary src, 2:i32 type, 3:i32 target),
    i32 iogp_fennel(1:binary src) throws (1: RedirectException r),
    i32 iogp_syncstatus(1: list<Status> statuses) throws (1: RedirectException r),

    i32 travel_master(1:i64 tid, 2:string payload),
    i32 travel_vertices(1:i64 tid, 2:i32 sid, 3:set<binary> keys, 4:string payload),
    set<binary> travel_edges(1:i64 tid, 2:i32 sid, 3:set<binary> keys, 4:string payload),
    set<i32> travel_start_step(1:i64 tid, 2:i32 sid, 3:string payload),

    i32 async_travel_master(1:i64 tid, 2:string payload),
    i32 async_travel_vertices(1:i64 tid, 2:i32 sid, 3:set<binary> keys, 4:i64 uuid, 5:i32 master, 6:string payload),
    i32 async_travel_edges(1:i64 tid, 2:i32 sid, 3:set<binary> keys, 4:i64 uuid, 5:i32 master, 6:string payload),
    i32 async_travel_report(1:i64 tid, 2:i32 sid, 3:set<i64> uuid, 4:i32 type),
}