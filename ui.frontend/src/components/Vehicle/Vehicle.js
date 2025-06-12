import React, { useEffect, useState } from 'react';
import { MapTo } from '@adobe/aem-spa-component-mapping';
import './Vehicle.css';

const Vehicle = (props) => {
  const [vehicles, setVehicles] = useState([]);

  // This will handle both initial and hydrated props
  useEffect(() => {
    const model = props?.cqModel || props;

    if (Array.isArray(model?.listOfVehicles)) {
      setVehicles(model.listOfVehicles);
    } else {
      setVehicles([]); // fallback to empty
    }
  }, [props]);

  if (!vehicles.length) {
    return <p>No vehicles found.</p>;
  }

  return (
    <div className="vehicle-container">
      <h2>Available Vehicles</h2>
      <div className="vehicle-grid">
        {vehicles.map((vehicle, index) => (
          <div key={index} className="vehicle-card">
            <img src={vehicle.productImage} alt={vehicle.productName} />
            <div className="vehicle-card-content">
              <h3>{vehicle.productName}</h3>
              <p><strong>Price:</strong> ₹{vehicle.productPrice}</p>
              <p><strong>Available:</strong> {vehicle.available}</p>
              <div
                className="description"
                dangerouslySetInnerHTML={{ __html: vehicle.productDescription }}
              />
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default MapTo('wknd-spa-react/components/vehicle')(Vehicle);
