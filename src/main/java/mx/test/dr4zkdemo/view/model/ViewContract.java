package mx.test.dr4zkdemo.view.model;

import mx.dr.forms.constants.FormActions;
import mx.dr.forms.view.DRFellowLink;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.DRRootEntity;
import mx.dr.forms.view.component.DRHtml;
import mx.dr.forms.view.component.DRLabel;

@DRRootEntity(entity = mx.test.vo.Contract.class)
@DRFellowLink(action= FormActions.READ,param = "type", paramAction = "mx.dr.ml.view.facade.ContractFacade@getContractCompany")
public class ViewContract {
	@DRField(actions= FormActions.READ, readParent = "contractCompany", label =@DRLabel(key = DRLabel.NO_LABEL))
	@DRHtml
	private String content;
}
