package EnterpriseTag;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
/**
 * First custom tag class
 * Created by peter on 3/21/2017.
 */
public class HelloWorldTag extends SimpleTagSupport{

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        out.println("Hello Ladies and Germs!");    }
}
