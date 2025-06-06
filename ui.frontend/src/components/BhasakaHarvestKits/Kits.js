import React,{useEffect} from 'react'
import { MapTo } from '@adobe/aem-spa-component-mapping';
import './Kits.css'

const Kits= ({ kits = [] }) => {
  return (
    <div className="kits-container">
      {kits.map((kit, index) => (
        <div className="kit-card" key={index}>
          <img src={kit.kitImage} alt={kit.kitName} className="kit-image" />
          <div className="kit-content">
            <h3 className="kit-title">{kit.kitName}</h3>
            <p className="kit-description">{kit.kitDescription}</p>
            <ul className="kit-features">
              {kit.features.map((feature, idx) => (
                <li key={idx}>{feature.features}</li>
              ))}
            </ul>
          </div>
        </div>
      ))}
    </div>
  );
};

export default MapTo('wknd-spa-react/components/kits')(Kits);
