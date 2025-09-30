public class Clone694 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:16232833
*  Stack Overflow answer #:38793791
*  And Stack Overflow answer#:33103086
*/
@RequestMapping (value = "/matches/{matchId}", produces = "application/json")
@ResponseBody
public String match (@PathVariable
String matchId) {
    String json = matchService.getMatchJson (matchId);
    if (json == null) {
        throw new NotFoundException ();
    }
    return json;
}

@RequestMapping (value = "/matches/{matchId}", produces = "application/json")
@ResponseBody
public ResponseEntity < ? > match (@PathVariable
String matchId,@RequestBody
String body, HttpServletRequest request, HttpServletResponse response) {
    Product p;
    try {
        p = service.getProduct (request.getProductId ());
    } catch (Exception ex) {
        return new ResponseEntity < String > (HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity (p, HttpStatus.OK);
}

}
