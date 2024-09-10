namespace count_numbers;

class Program
{
    static void Main(string[] args)
    {
        //Without Multi Threading
        // countUp();
        // countDown();
        Thread a = new Thread(countUp);
        Thread b = new Thread(countDown);
        a.Start();
        b.Start();
    }

    static void countUp()
    {
        for (int idx = 0; idx < 10; ++idx)
        {
            Console.WriteLine($"{idx} by countUp");
            Thread.Sleep(100);
        }
    }

    static void countDown()
    {
        for (int idx = 10; idx >= 0; --idx)
        {
            Console.WriteLine($"{idx} by countDown");
            Thread.Sleep(100);
        }
    }
}
