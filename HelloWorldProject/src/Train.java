public class Train {
    private String name, product, origin, destination;
    private int weight, miles;

    public Train(String nombre, String contents, String start, String city, int size, int distance){
        name = nombre;
        product = contents;
        origin = start;
        destination = city;
        weight = size;
        miles = distance;
    }

    public Train(String nombre, String city){
        name = nombre;
        destination = city;
    }

    public String getName(){
        return name;
    }

    public String getProduct(){
        return product;
    }

    public String getOrigin(){
        return origin;
    }

    public String getDestination(){
        return destination;
    }

    public int getWeight(){
        return weight;
    }

    public int getMiles(){
        return miles;
    }

    public int setMiles(){
        miles = 100;
        return miles;
    }

    public String toString(){
        return "Name: " + this.name + "\n Product: " + this.product + "\n Origin: " + this.origin + "\n Destination: " + this.destination + "\n Weight: " + this.weight + "\n Miles: " + this.miles;
    }
}
