package com.packt.webstore.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

@XmlRootElement
public class Product implements Serializable {
    
    private static final long serialVersionUID =3678107792576131001L;
    
    
    @Pattern(regexp="P[1-9]+", message="{Pattern.Product.productId.validation}")
    private String productId;
    
    @Size(min=4, max=50, message="{Size.Product.name.validation}")
    private String name;
    
    @Min(value=0, message="{Size.Product.name.validation}")
    private BigDecimal unitPrice;
    
    

    private String description;
    private String manufacturer;
    private String category;
    private long unitsInStock;
    private long unitsInOrder;
    private boolean discontinued;
    private String condition;
    
    @JsonIgnore
    private MultipartFile productImage;
     
    public Product(){
        super();
    }
    public Product(String productId, String name, BigDecimal unitPrice){
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
    }
    
    //add setters and getters for all the fields here

    public void setProductId(String productId) {this.productId = productId;}
    public String getProductId() {return productId;}  

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}    

    public void setUnitPrice(BigDecimal unitPrice) {this.unitPrice = unitPrice;}
    public BigDecimal getUnitPrice() {return unitPrice;}    

    public void setDescription(String description) {this.description = description;}
    public String getDescription() {return description;}
    
    public void setManufacturer(String manufacturer) {this.manufacturer = manufacturer;}
    public String getManufacturer() {return manufacturer;}
    
    public void setCategory(String category) {this.category = category;}
    public String getCategory() {return category;}
    
    public void setUnitsInStock(long unitsInStock) {this.unitsInStock = unitsInStock;}
    public long getUnitsInStock() {return unitsInStock;}
    
    public void setUnitsInOrder(long unitsInOrder) {this.unitsInOrder = unitsInOrder;}
    public long getUnitsInOrder() {return unitsInOrder;}
    
    public void setDiscontinued(boolean discontinued) {this.discontinued = discontinued;}
    public boolean getDiscontinued() {return discontinued;}
    
    public void setCondition(String condition) {this.condition = condition;}
    public String getCondition() {return condition;}

    public void setProductImage(MultipartFile productImage){this.productImage = productImage;}
    
    @XmlTransient
    public MultipartFile getProductImage() {return productImage;}
    
    
    
  
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        return true;
        if (obj == null)
        return false;
        if (getClass() != obj.getClass())
        return false;
        Product other = (Product) obj;
        if (productId == null) {
        if (other.productId != null)
        return false;
        } else if (!productId.equals(other.productId))
        return false;
        return true;                            
    }

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
        +((productId == null) ? 0 :
        productId.hashCode());
        return result;
    }       
}