public class App {
    public static void main(String[] args) throws Exception {
        Veiculo carro = new Carro("C40", 2022, "Azul", false, 4, 4, "Automática", 25);
        Veiculo moto = new Moto("Biz", 2020, "Vermelha", false, 2, 150, "Flex", "Sei la");
        Veiculo bicicleta = new Bicicleta("Caloi", 2020, "Azul", false, 2, 5, "Lona", "Sei lá");
        Veiculo onibus = new Onibus("Biarticulado", 2020, "Vermelho", false, 12, 200, 4, 20);
        Veiculo submarino = new Submarino("Sub 123", 2000, "Cinza", false, 20, 3000);
        Veiculo aviao = new Aviao("A380", 2020, "Branco", false, 4, 15, "Querosene de Aviação");
        Veiculo helicoptero = new Helicoptero("Hel123", 2015, "Verde", false, 2, 6, 5);

        System.out.println(carro);
        System.out.println(moto);
        System.out.println(bicicleta);
        System.out.println(onibus);
        System.out.println(submarino);
        System.out.println(aviao);
        System.out.println(helicoptero);
    }
}
