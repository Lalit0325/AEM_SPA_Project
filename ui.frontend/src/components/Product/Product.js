import React from 'react';
import { MapTo } from '@adobe/aem-spa-component-mapping';
import parse from 'html-react-parser';

function Product(props) {
  const { productName, text } = props;

  return (
    <div>
      <h1>Product Name: {productName}</h1>
      {/* Safely parse only if text is a string */}
      {typeof text === 'string' ? (
        <div>{parse(text)}</div>
      ) : (
        <div>No description available</div>
      )}
    </div>
  );
}

export default MapTo('wknd-spa-react/components/product')(Product);
