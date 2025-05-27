import React from 'react';
import { MapTo } from '@adobe/aem-react-editable-components';
import './Navigation_Menu.css';

function Navigation_Menu(props) {
    console.log("Navigation_Menu props:", props);

    return (
        <div className='nav-container'>
            {props.logoPath && (
                <img src={props.logoPath} alt={props.logoAltText || 'Logo'} className='logo-img' />
            )}
            <ul>
                {(props.links || []).map((link, index) => (
                    <li key={index}><a href={link.pageLink}>{link.pageTitle}</a></li>
                ))}
            </ul>
        </div>
    );
}

export default MapTo('wknd-spa-react/components/navigation_menu')(Navigation_Menu);
