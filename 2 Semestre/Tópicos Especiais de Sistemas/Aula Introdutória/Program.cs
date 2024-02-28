//EXEMPLO 1
// Console.WriteLine("Digite a mensagem: ");
// string mensagem = Console.ReadLine();

// Console.WriteLine(mensagem);

//EXEMPLO 2
// Console.WriteLine("Digite o valor 'a': ");
// string strA = Console.ReadLine();

// Console.WriteLine("Digite o valor 'b': ");
// string strB = Console.ReadLine();

// int a = Convert.ToInt32(strA);
// int b = Convert.ToInt32(strB);

// int resultado = a + b;

// Console.WriteLine("Soma de 'a' e 'b' é: " + resultado);

//EXEMPLO 3
// Console.WriteLine("Digite o valor 'a': ");
// int a = Convert.ToInt32(Console.ReadLine());

// Console.WriteLine("Digite o valor 'b': ");
// int b = Convert.ToInt32(Console.ReadLine());

// Console.WriteLine($"O resultado é: {a + b}");

// if((a + b) >= 6)
//     Console.WriteLine("Aluno aprovado!");
// else
//     Console.WriteLine("Aluno reprovado!");


//EXEMPLO 4
bool executar = true;
int contador = 0;
string[] letras = new string[]{"A", "B", "C", "D", "E"};

// while(executar && contador < letras.Length){
//     var letra = letras[contador];
//     Console.WriteLine("Letra: " + letra);
//     contador++;
// }

foreach(var letra in letras){
    Console.WriteLine("Letra: " + letra);
}