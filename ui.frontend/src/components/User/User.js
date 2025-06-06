import React from 'react';
import { MapTo } from '@adobe/aem-spa-component-mapping';
import parse from 'html-react-parser'

function User(props) {
  console.log("Author Data:", props);
  const { userName, authorData } = props;
  return (
    <div>
      <h1>Name: {userName}</h1>
      
       
      {authorData && (
        <div>
          <p>Name: {authorData.name}</p>
          <p>Age: {authorData.age}</p>
          <p>Address: {parse(authorData.address)}</p>
        </div>
      )}
    </div>
  );
}

export default MapTo('wknd-spa-react/components/user')(User);
