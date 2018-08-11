package weile.springboot.elasticsearch;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "order",type = "orderschema")
public class OrderInfo implements Serializable {

    @Id
    private String docId;
    private String orderno;
    private Integer paystatus;
    private Integer status;

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public Integer getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(int paystatus) {
        this.paystatus = paystatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }
}
