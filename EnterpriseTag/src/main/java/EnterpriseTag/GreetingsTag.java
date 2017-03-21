package EnterpriseTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalTime;

/**
 * First custom tag class
 * Created by peter on 3/21/2017.
 */
public class GreetingsTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();
        JspWriter out = getJspContext().getOut();
        if (hour < 12) {
            out.println("Origato gozaimas");
        } else {
            out.println("Konichiwa");
        }
    }
}
