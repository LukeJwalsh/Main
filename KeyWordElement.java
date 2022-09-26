public class KeyWordElement
{
    public String word;
    public KeyWordElement next;


    public NextWordList nextwordlist;


    public KeyWordElement(String word)
    {
        this.word=word;
        next=null;
        nextwordlist = new NextWordList();
    }

}
