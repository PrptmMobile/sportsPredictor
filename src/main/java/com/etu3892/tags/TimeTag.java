package com.etu3892.tags;


import com.etu3892.functional.SportsDateTime;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.IOException;

public class TimeTag extends SimpleTagSupport {
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println(new SportsDateTime(System.currentTimeMillis()).toString());
    }
}
