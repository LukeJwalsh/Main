public class KeyWordList
{
    public KeyWordElement startoflist;
    public KeyWordElement endoflist;








    int size;
    //Step 1

    //KeyWordElement
    // start, end
    //KeyWordList()

    public KeyWordList()
    {
        startoflist=null;
        endoflist=null;
        size=0;
    }


    public void add(String s )
    {
        //make a capsule to hold a value and link
        KeyWordElement e=new  KeyWordElement(s);
        NextWordList nextwordlist = e.nextwordlist;



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

    public void addUnique(String s )
    {
        //null = new NextWordList
        //Only add the word if you cant find the word in the list already
        if(findElement(s)==null)
            add(s);
    }


    public void print()
    {
        //LinkedListElement start=start of list
        for(KeyWordElement start=startoflist ;start!=null;start=start.next)
//        while(start!=null)
        {
            System.out.println("\n"+start.word + ":");
            start.nextwordlist.print();
            //    start = start.next;
        }
        System.out.println(); //System.out.println(word)

    }

    //public int length()
    // {
    //   return size;
    //}

    public int find(String s)
    {
        KeyWordElement current=startoflist;
        for(int i=0; i<size; i++)
        {
            if(current.word.equals(s))
                return i;
            current=current.next;
        }
        return -1;
    }


    public String get(int index)
    {
        KeyWordElement current = startoflist;
        for(int i=0; i<index; i++)
        {
            current=current.next;
        }
        //now current is the element
        return current.word;
    }
    //}

    public void foundWordSequence(String Keyword,String Nextword)
    {
        //Calls add unique
        // adds nextword to that keywords nextwordlist with foundNextWord
        // make a new function findPtr that returns the key word element instead of the index
        //- calls addUnique to find the keyword element if it exists or make a new one if it doesn't
        //- adds nextword to that keyword's nextwordlist with foundNextWord
        addUnique(Keyword);
        findElement(Keyword).nextwordlist.foundNextWord(Nextword);

        //Find element
    }


    public KeyWordElement findElement(String s)
    {
        KeyWordElement current=startoflist;
        for(int i=0; i<size; i++)
        {
            if(current.word.equals(s))
                return current;
            current=current.next;
        }
        return null;
    }

    String getRandomNextWord(String keyword)
    {
        KeyWordElement word = findElement(keyword);
        if(word.nextwordlist.getRandomWord()==null)
        {
            return null;
        }
        String random = word.nextwordlist.getRandomWord();
        return random;
    }

    String getRandomKeyword()
    {
        String random = "";
        int totalcount=0;
        int runningCount=0;
        for (KeyWordElement start = startoflist; start != null; start = start.next)
        {

            totalcount++;
        }
        int choice = (int)(Math.random()* totalcount);
        for (KeyWordElement start = startoflist; start != null; start = start.next)
        {
            int count = 1;
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



