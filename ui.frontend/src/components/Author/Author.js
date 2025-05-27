import React, { Component } from 'react';
import { MapTo } from '@adobe/aem-react-editable-components';
import './Author.css';
export const CustomEditConfig = {
  emptyLabel: "Author",
  isEmpty: function (props) {
    return !props || !props.name || props.name.trim().length < 1;
  }
};

class Author extends Component {
  render() {
    if (CustomEditConfig.isEmpty(this.props)) {
      return null;
    }
    return (
      <div>
        <h1 className='head'>Author</h1>
        <h2 className='data'>{this.props.name}</h2>
        <h3 className='data'>{this.props.age}</h3>
      </div>
    );
  }
}

export default MapTo('wknd-spa-react/components/author')(Author, CustomEditConfig);
