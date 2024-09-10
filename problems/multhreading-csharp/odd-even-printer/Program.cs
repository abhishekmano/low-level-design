namespace odd_even_printer;

class Program
{
    public static readonly object _lock = new object();
    public static int _number = 1;

    static void Main(string[] args)
    {
        Thread a = new Thread(OddPrinter);
        Thread b = new Thread(EvenPrinter);
        a.Start();
        b.Start();
    }

    public static void OddPrinter()
    {
        while (_number < 10)
        {
            lock (_lock)
            {
                if (_number % 2 == 1)
                {
                    Console.WriteLine($"Odd Thread Printing {_number}");
                    _number++;
                    Monitor.Pulse(_lock);
                }
                else
                {
                    Monitor.Wait(_lock);
                }
            }
        }
    }

    public static void EvenPrinter()
    {
        while (_number < 10)
        {
            lock (_lock)
            {
                if (_number % 2 == 0)
                {
                    Console.WriteLine($"Even Thread Printing {_number}");
                    _number++;
                    Monitor.Pulse(_lock);
                }
                else
                {
                    Monitor.Wait(_lock);
                }
            }
        }
    }
}
