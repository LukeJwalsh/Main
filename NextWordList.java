import java.util.Random;


public class NextWordList
{
    public NextWordElement startoflist;
    public NextWordElement endoflist;

    int size;

    public NextWordList()
    {
        startoflist=null;
        endoflist=null;
        size=0;
    }


    //Next WE
    // Start, end
    //NextWL()

//Will be a new list that will hold the word and what follows after it and how many times

    void foundNextWord(String nextword)
    {

        if(find(nextword)==-1)
        {
            add(nextword);
        }
        else
        {
            NextWordElement Next = findElement(nextword);
            Next.count++;
        }

    }

    public int find(String s)
    {
        NextWordElement current=startoflist;
        for(int i=0; i<size; i++)
        {
            if(current.word.equals(s))
                return i;
            current=current.next;
        }
        return -1;
    }

    public NextWordElement findElement(String s)
    {
        NextWordElement current=startoflist;
        for(int i=0; i<size; i++)
        {
            if(current.word.equals(s))
                return current;
            current=current.next;
        }
        return null;
    }

    void print()
    {
        for (NextWordElement start = startoflist; start != null; start = start.next)
        {
            System.out.println("\t-"+start.word + " "+start.count);
        }
    }

    public void add(String s )
    {
        //make a capsule to hold a value and link
        NextWordElement e=new  NextWordElement(s);
        //two situations: list is empty, list isn't

        if(startoflist==null)
        {
            //make that element e both the beginning and end
            startoflist=e;
            endoflist=e;
        }
        else
        {
            //make current end point to e as next element
            endoflist.next=e;
            //e is now the end
            endoflist=e;
        }
        size++;
    }

    public String getRandomWord()
    {
        String random = "";
        int totalcount=0;
        int runningCount=0;
        for (NextWordElement start = startoflist; start != null; start = start.next)
        {
            int count = start.count;
            totalcount = totalcount + count;
        }
        int choice = (int)(Math.random()* totalcount+1 );
        for (NextWordElement start = startoflist; start != null; start = start.next)
        {
            int count = start.count;
            runningCount = runningCount + count;
            if(runningCount>=choice)
            {
                random = start.word;
                return random;
            }

        }
        return null;
    }

}