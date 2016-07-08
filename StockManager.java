import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        Product producto = findProduct(item.getID());
        if( (producto != null) && (item.getName() == producto.getName()) ){
            System.out.println("Error, producto con un ID ya exixtente");
        }
        else{
            stock.add(item);
        }
    }

    /**
     * Receive a delivery of a particular product.   ------Recibe una entrega de un producto en particular.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product product = findProduct(id);
        if(product != null){
            product.increaseQuantity(amount);
            product.getQuantity();
        }
        else{
            System.out.println("No hay productos con el ID: " +id);
        }
    }

    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id){
        //recordemos¡¡¡. un bucle while: en una busqueda, deja de iterar cuando encuentra lo que busca.
        //teniendo en cuenta que nos piden devolver null si no tenemos el producto buscado, hemos de crea un objeto Producto 
        Product producto = null;   //con valor null.
        //en este caso, para que funcione el bucle while necesito una VL booleana y otra más de tipo entero.
        boolean encontrado = true;
        int index = 0;
        while(encontrado && stock.size() > index){//mientras estas dos condiciones se cumplan, el bucle recorrerá la colección.
            if(stock.get(index).getID() == id){   // de producto en producto. ¡Si el ID de uno de los productos es == al id 
                producto = stock.get(index);      //pasado como parámetro. lo almacenamos en la VL producto. y..
                encontrado = false;               //cambiamos el valor de  la VL encontrado a false para que el while deje de iterar.
            }
            index ++;                             //importante¡¡¡ aumentar el contador.
        } 
        return producto;  //finalmente esta la VL producto devuelve el valor que se haya almacenado en ella a lo largo del proceso
    }

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        int valor = 0;
        Product producto = findProduct(id);
        if(producto != null){
            valor = producto.getQuantity();
        }
        for (int index = 0; index<stock.size(); index++) {
            if (stock.get(index).getID()==id) {
                valor++;
            }
        }
        return valor;
    }

    /**
     * imprime los detalles de todos los productos cuyo stock está por debajo de un determinado número que será pasado 
     * como parámetro al método ---------------------------------------------------------------------------------- 0065
     */
    public void underGivenNumberInStock(int cantidad){
        System.out.println("Productos con una cantidad inferior a " +cantidad+ " unidades.");
        for(Product producto: stock){
            if(producto.getQuantity() < cantidad){
                System.out.println(producto);
            }
        }
    }
    
    /**
     * permita encontrar productos por su nombre en vez de por su id. En caso de no encontrarse una coincidencia exacta
     * el método devuelve null. La cabecera del método debe ser: -------------------------------------------------- 0065
     */
    public Product findProduct(String name){
        Product producto = null;
        
        return producto;
    }
    
    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for(Product producto: stock){
            System.out.println(producto.toString());
        }

    }
}
