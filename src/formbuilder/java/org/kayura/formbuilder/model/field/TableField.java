package org.kayura.formbuilder.model.field;

import java.util.List;

import org.kayura.formbuilder.model.FormField;

public class TableField extends LableField {

	private String actionName;
	private List<FormField> children;

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public List<FormField> getChildren() {
		return children;
	}

	public void setChildren(List<FormField> children) {
		this.children = children;
	}

}
