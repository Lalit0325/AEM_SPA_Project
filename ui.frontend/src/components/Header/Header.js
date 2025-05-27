import React,{Component} from 'react'

export default class Header extends Component {
  render()
  {
    return (
        <header className='Header'>
            <div className='Header-container'>
                <h1>About</h1>
                <h1>Home</h1>
                <h1>Contact</h1>
            </div>
        </header>
      );
  }
}

