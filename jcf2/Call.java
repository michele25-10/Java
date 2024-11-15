package linguaggiProgrammazione.jcf2;

class Call {
    final String PATH_FILE = "data.txt";
    private String sender;
    private String receiver;
    private int start;
    private int end;

    public Call(String sender, String receiver, int start, int end) {
        this.sender = sender;
        this.receiver = receiver;
        this.start = start;
        this.end = end;
    }

    public int getDuration() {
        return this.end - this.start;
    }

}