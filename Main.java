import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Part1();
    }

    public static void Part1()
    {
        KeyWordList list = new KeyWordList();
        NextWordList nextwordlist = new NextWordList();
        Scanner input = new Scanner(System.in);
        System.out.print("What file would you like to work with? ---> ");
        String fileName = input.next();
        System.out.println();


        try {
            String fname = fileName + ".txt";
            FileReader fread = new FileReader(fname);
            Scanner scan = new Scanner(fread);
            System.out.print("What size sequences would you like to use? ---> ");
            int sequencenum = input.nextInt();
            System.out.println();
            ArrayList<String> Keywords = new ArrayList<>();
            String word1 = scan.next();
            word1 = word1.replaceAll("\\p{Punct}", "");
            Keywords.add(word1);
            String Keyword = null;
            String words = null;
            if (sequencenum>1) 
            {
                for (int i = 0; i < sequencenum - 1; i++) {
                    String word = scan.next();
                    word = word.replaceAll("\\p{Punct}", "");
                    Keywords.add(word);

                }


                words = Keywords.toString();
                words = words.substring(1, words.length() - 1);
                words = words.replaceAll(",", "");
            }
            else
            {
                Keyword = scan.next().toLowerCase();
                Keyword = Keyword.replaceAll("\\p{Punct}",""); 
            }
            

            ArrayList<String> Nextwords = new ArrayList<>();
            while (scan.hasNext())
            {
                if(sequencenum>1)
                {
                    Keyword = words;
                    String Next = scan.next();
                    Next = Next.replaceAll("\\p{Punct}", "");
                    nextwordlist.foundNextWord(Keyword);
                    nextwordlist.foundNextWord(Next);
                    list.foundWordSequence(Keyword, Next);


                    Nextwords.clear();
                    String lastword = words.substring(words.indexOf(" ")+1);
                    Nextwords.add(lastword+" "+Next);

                    String word=Nextwords.toString();
                    word = word .substring(1,word.length()-1);
                    word = word.replaceAll(",","");

                    words = word;

                }
                else
                {
                    String word= scan.next().toLowerCase();
                    word = word.replaceAll("\\p{Punct}", "");
                    list.foundWordSequence(Keyword,word);
                    nextwordlist.foundNextWord(word);
                    Keyword=word;

                }
            }

            list.print();

            int line = 0;

            String startword = list.getRandomKeyword();
            System.out.println();
            System.out.print(startword + " ");

            for (int i=0; i<200; i++)
            {
                if (sequencenum>1)
                {
                line++;
                String nextword = list.getRandomNextWord(startword);
                System.out.print(nextword+" ");
                startword = startword+" "+nextword;

                startword = startword.substring(startword.indexOf(" ") + 1, startword.length());

                    if(line>25)
                    {
                        System.out.println();
                        line = line-25;
                    }

                }
                else
                {
                    line++;
                    String nextword = list.getRandomNextWord(startword);
                    System.out.print(nextword+" ");
                    startword = nextword;
                    if(line>25)
                    {
                        System.out.println();
                        line = line-25;
                    }

                }
            }

        }
           catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        }

    }


}