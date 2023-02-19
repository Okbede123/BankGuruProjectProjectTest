package cores.commons.singatonpattern;

public class GlobalConstant {

    private static GlobalConstant globalConstant;

    private GlobalConstant(){

    }

    public static GlobalConstant getGlobalConstant(){
        if(globalConstant == null){
            globalConstant = new GlobalConstant();
        }
        return globalConstant;
    }
}
