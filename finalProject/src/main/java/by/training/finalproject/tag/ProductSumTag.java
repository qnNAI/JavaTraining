package by.training.finalproject.tag;

import by.training.finalproject.entity.ProductList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

public class ProductSumTag extends TagSupport {
    private List<ProductList> listOfProductList;

    public List<ProductList> getListOfProductListList() {
        return listOfProductList;
    }

    public void setListOfProductList(List<ProductList> listOfProductList) {
        this.listOfProductList = listOfProductList;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            double sum = 0;
            for (ProductList productList : listOfProductList) {
                sum += productList.getFinalPrice();
            }
            pageContext.getOut().print("" + sum);
        } catch (Exception ex) {
            throw new JspTagException("Product sum tag failed", ex);
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() {
        return EVAL_PAGE;
    }
}
