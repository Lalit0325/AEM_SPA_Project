import React from 'react';
import { MapTo } from '@adobe/aem-react-editable-components';
import './Student.css';

export const CustomEditConfig = {
  emptyLabel: "Student",
  isEmpty: function (props) {
    return !props || !props.name || props.name.trim().length < 1;
  }
};

const Student = (props) => {
  if (CustomEditConfig.isEmpty(props)) {
    return null;
  }

  return (
    <div className='student-card'>
      <h1 className='head'>Student Profile</h1>
      <img src={props.image} alt='Student Image' />
      <h2 className='data'>Name :: {props.name}</h2>
      <h3 className='data'>Age :: {props.age}</h3>
      <p><strong>Skills:</strong></p>
      <ul>
        {props.skills && props.skills.map((skill, index) => (
          <li key={index}>{skill}</li>
        ))}
      </ul>
    </div>
  );
};

export default MapTo('wknd-spa-react/components/student')(Student, CustomEditConfig);
