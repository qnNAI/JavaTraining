package by.training.customTag.view;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Locale;

@SuppressWarnings("serial")
public class InfoTimeTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        GregorianCalendar calendar = new GregorianCalendar();
        String time = "<hr/>Time : <b> " + calendar.getTime() + " </b><hr/>";
        String locale = "<hr/>Locale : <b> " + Locale.getDefault() + " </b><hr/> ";

        try {
            JspWriter out = pageContext.getOut();
            out.write(time + locale);
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
