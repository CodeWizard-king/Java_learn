package Listtest;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-06-01
 * Time: 19:21
 */
public class PosIllegal extends RuntimeException{
    public PosIllegal(){

    }
    public PosIllegal(String msg){
        super(msg);
    }
}
