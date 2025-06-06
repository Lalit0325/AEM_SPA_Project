import React from 'react';
import { MapTo } from '@adobe/aem-spa-component-mapping';


function Vehicle(props) {

  return (
    <div>
      <h1>Product Name: {props.cfPath}</h1>
    </div>
  );
}

export default MapTo('wknd-spa-react/components/vehicle')(Vehicle);
