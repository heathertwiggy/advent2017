package util;

public class Input {
    final Read.Mode mode;
    final int day;
    final String suffix;

    private Input(Read.Mode mode, int day, String suffix) {
        this.mode = mode;
        this.day = day;
        this.suffix = suffix;
    }

    public static Input für(Read.Mode mode, int day, String suffix){
        return new Input(mode,day,suffix);
    }

    public static Input für(Read.Mode mode, int day){
        return new Input(mode,day,"");
    }

    public static Input für(int day){
        return new Input(Read.Mode.REAL, day, "");
    }
}
