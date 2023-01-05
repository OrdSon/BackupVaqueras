using System;
namespace CrearTxt




{
    class Program
    {
        static void Main(string[] args)
        {
            string[] lines = { "Primera Linea", "Segunda Linea", "Tercera Linea" };
            System.IO.File.WriteAllLines(@"C:\RutaArchivos\EscribeLineas.txt", lines);
            string text = "A class is the most powerful data type in C#. Like a structure, " +
                           "a class defines the data and behavior of the data type. ";
            System.IO.File.WriteAllText(@"C:\RutaArchivos\EscribeTexto.txt", text);
            using (System.IO.StreamWriter file = new System.IO.StreamWriter(@"C:\RutaArchivos\EscribeLineas2.txt"))
            {
                foreach (string line in lines)
                {
                    if (!line.Contains("Segunda"))
                    {
                        file.WriteLine(line);
                    }
                }
            }
            using (System.IO.StreamWriter file = new System.IO.StreamWriter(@"C:\RutaArchivos\EscribeLineas2.txt", true))
            {
                file.WriteLine("Cuarta Linea");
            }
        }
    }
}