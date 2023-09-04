import React, { Component } from 'react';
import EmployeeService from '../service/EmployeeService';

class EmployeeComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            employee: {},
            department:{},
            company: {}
        }
    }

    componentDidMount()
    {
        EmployeeService.getEmployee().then(
            (response) => {
              //  console.log("1. "+JSON.stringify(response));
                this.setState({employee: response.data.employee});
                this.setState({department: response.data.employee.department});
                this.setState({company: response.data.employee.company});

                console.log("1. "+JSON.stringify(this.state.employee));
                console.log("5. "+JSON.stringify(this.state.department));
                console.log("9. "+JSON.stringify(this.state.company));
            }
        )
    }
    
    render() {
        return (
            <div> <br /><br />
            <div className='card col-md-4 offset-md-4'>
                <h3 className='text-center card-header'> View Employee Details</h3>
                <div className='card-body'>
                    <div className='row'>
                        <p><strong>Employee First Name: </strong> {this.state.employee.firstName}</p>
                    </div>
                    <div className='row'>
                        <p><strong>Employee Last Name: </strong> {this.state.employee.lastName}</p>
                    </div>
                    <div className='row'>
                        <p><strong>Employee Email: </strong> {this.state.employee.email}</p>
                    </div>
                </div>
                <h3 className='text-center card-header'> View Department Details</h3>
                <div className='card-body'>
                    <div className='row'>
                        <p><strong>Department Name: </strong> {this.state.department.name }</p>
                    </div>
                    <div className='row'>
                        <p><strong>Department Description: </strong> {this.state.department.description }</p>
                    </div>
                    <div className='row'>
                        <p><strong>Department code: </strong> {this.state.department.code }</p>
                    </div>
                </div>
                <h3 className='text-center card-header'> View Organization Details</h3>
                <div className='card-body'>
                    <div className='row'>
                        <p><strong> Organization Name: </strong> {this.state.company.name } </p>
                    </div>
                    <div className='row'>
                        <p><strong> Organization Description: </strong> {this.state.company.description } </p>
                    </div>
                    <div className='row'>
                        <p><strong> Organization Code: </strong> {this.state.company.code } </p>
                    </div>
                </div>
            </div>
        </div>
        );
    }
}

export default EmployeeComponent;