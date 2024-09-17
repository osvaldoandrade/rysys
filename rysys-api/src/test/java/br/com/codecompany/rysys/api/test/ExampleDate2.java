package br.com.codecompany.rysys.api.test;

import br.com.codecompany.rysys.api.annotation.Direction;
import br.com.codecompany.rysys.api.annotation.core.DataDescriptor;
import br.com.codecompany.rysys.api.annotation.core.DateField;
import java.util.Date;

@DataDescriptor
public class ExampleDate2 {

	@DateField(index=1,
	           length=8,
			   beginIndex=0,
			   mask="ddMMyyyy",
			   forceZeroToNull=false,
			   direction=Direction.FROM_EIS)
	private Date date1;

	@DateField(index=2,
	           length=8,
			   beginIndex=8,
			   mask="ddMMyyyy",
			   forceZeroToNull=true,
			   direction=Direction.FROM_EIS)
	private Date date2;

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}
}
