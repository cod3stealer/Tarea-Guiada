public class ConTemp {
    public static Float celToFar(Float celsius){
        return celsius * ( 9 / 5 ) + 32;
    }
    public static Float farToCel(Float faren){
        return (faren - 32) * 5 / 9;
    }
}
