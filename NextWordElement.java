public class NextWordElement
{
    public String word;
    public int count;
    public NextWordElement next;

    public NextWordElement(String word)
    {
        this.word = word;
        count =1;
        next = null;
    }
}
