public class Clone356 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:36508323
*  Stack Overflow answer #:46850645
*  And Stack Overflow answer#:36529534
*/
public Object read (JsonReader in) throws IOException {
    JsonToken token = in.peek ();
    switch (token) {
        case BEGIN_ARRAY :
            List < Object > list = new ArrayList < Object > ();
            in.beginArray ();
            while (in.hasNext ()) {
                list.add (read (in));
            }
            in.endArray ();
            return list;
        case BEGIN_OBJECT :
            Map < String, Object > map = new LinkedTreeMap < String, Object > ();
            in.beginObject ();
            while (in.hasNext ()) {
                map.put (in.nextName (), read (in));
            }
            in.endObject ();
            return map;
        case STRING :
            return in.nextString ();
        case NUMBER :
            String n = in.nextString ();
            if (n.indexOf ('.') != - 1) {
                return Double.parseDouble (n);
            }
            return Long.parseLong (n);
        case BOOLEAN :
            return in.nextBoolean ();
        case NULL :
            in.nextNull ();
            return null;
        default :
            throw new IllegalStateException ();
    }
}

public Object read (JsonElement in) {
    if (in.isJsonArray ()) {
        List < Object > list = new ArrayList < Object > ();
        JsonArray arr = in.getAsJsonArray ();
        for (JsonElement anArr : arr) {
            list.add (read (anArr));
        }
        return list;
    } else if (in.isJsonObject ()) {
        Map < String, Object > map = new LinkedTreeMap < String, Object > ();
        JsonObject obj = in.getAsJsonObject ();
        Set < Map.Entry < String, JsonElement > > entitySet = obj.entrySet ();
        for (Map.Entry < String, JsonElement > entry : entitySet) {
            map.put (entry.getKey (), read (entry.getValue ()));
        }
        return map;
    } else if (in.isJsonPrimitive ()) {
        JsonPrimitive prim = in.getAsJsonPrimitive ();
        if (prim.isBoolean ()) {
            return prim.getAsBoolean ();
        } else if (prim.isString ()) {
            return prim.getAsString ();
        } else if (prim.isNumber ()) {
            Number num = prim.getAsNumber ();
            if (Math.ceil (num.doubleValue ()) == num.longValue ()) return num.longValue ();
            else {
                return num.doubleValue ();
            }
        }
    }
    return null;
}

}
