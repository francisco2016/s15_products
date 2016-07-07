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
        stock.add(item);
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
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
        for (int index = 0; index<stock.size(); index++) {
            if (stock.get(index).getID()==id) {
                valor++;
            }
        }
        return valor;
        //         int valor = 0;
        //         Product producto = findProduct(id);
        //         for(int i = 0; i < stock.size(); i++){
        //             if( (stock.get(i).getID() == producto.getID()) && (producto != null) ){
        //                 valor ++;
        //             }
        //         }
        //         return valor;
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
