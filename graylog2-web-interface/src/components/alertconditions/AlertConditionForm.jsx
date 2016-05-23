import React from 'react';
import { Input, Well } from 'react-bootstrap';

import AlertConditionsFactory from 'logic/alertconditions/AlertConditionsFactory';

const AlertConditionForm = React.createClass({
  propTypes: {
    type: React.PropTypes.string.isRequired,
    alertCondition: React.PropTypes.object,
  },
  alertConditionsFactory: new AlertConditionsFactory(),
  getValue() {
    return {
      title: this.refs.title.value,
      parameters: this.refs.conditionForm.getValue(),
    };
  },
  getDefaultProps() {
    return {
      alertCondition: {
        parameters: {},
      }
    };
  },

  _formatConditionFormFields(type) {
    const typeDefinition = this.alertConditionsFactory.get(type);

    if (typeDefinition !== undefined) {
      return <typeDefinition.configuration_form ref="conditionForm" alertCondition={this.props.alertCondition.parameters}/>;
    }

    return undefined;
  },
  render() {
    const alertCondition = this.props.alertCondition || {parameters: {}};
    return (
      <Well className="alert-type-form alert-type-form-message-count form-inline well-sm">
        Title: <input ref="title" type="text" className="form-control" autoComplete="off" defaultValue={alertCondition.title}/>
        {' '}
        <small>This title can also be included in alert notifications.</small>

        <p />
        {this._formatConditionFormFields(this.props.type)}
      </Well>
    );
  }
});

export default AlertConditionForm;
