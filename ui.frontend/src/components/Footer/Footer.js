import React from 'react'
import { MapTo } from '@adobe/aem-spa-component-mapping'
import './Footer.css'

function Footer(props) {
  return (
    <footer className="footer-section">
      <div className="container">
        <div className="row">

          {/* Contact Info */}
          <div className="col-lg-3 col-md-6">
            <div className="footer-box">
              <h3 className="footer-title">Contact Us</h3>
              <div className="footer-contact">
                <p><i className="fa fa-map-marker-alt"></i> 456 Garden Ave, CA, USA</p>
                <p><i className="fa fa-envelope"></i> support@gardenkits.com</p>
                <p><i className="fa fa-phone-alt"></i> +1 987-654-3210</p>
                <div className="footer-social">
                  <a href="#"><i className="fab fa-facebook-f"></i></a>
                  <a href="#"><i className="fab fa-twitter"></i></a>
                  <a href="#"><i className="fab fa-linkedin-in"></i></a>
                  <a href="#"><i className="fab fa-instagram"></i></a>
                </div>
              </div>
            </div>
          </div>

          {/* Useful Links */}
          <div className="col-lg-3 col-md-6">
            <div className="footer-box">
              <h3 className="footer-title">Resources</h3>
              <ul className="footer-links">
                <li><a href="#">About Gardening</a></li>
                <li><a href="#">Beginner Tips</a></li>
                <li><a href="#">Plant Care</a></li>
                <li><a href="#">Indoor Kits</a></li>
                <li><a href="#">Outdoor Ideas</a></li>
              </ul>
            </div>
          </div>

          {/* Quick Links */}
          <div className="col-lg-3 col-md-6">
            <div className="footer-box">
              <h3 className="footer-title">Quick Links</h3>
              <ul className="footer-links">
                <li><a href="#">FAQs</a></li>
                <li><a href="#">Help Center</a></li>
                <li><a href="#">Returns</a></li>
                <li><a href="#">Shipping Info</a></li>
                <li><a href="#">Terms & Conditions</a></li>
              </ul>
            </div>
          </div>

          {/* Newsletter */}
          <div className="col-lg-3 col-md-6">
            <div className="footer-box">
              <h3 className="footer-title">Join Our Newsletter</h3>
              <div className="footer-newsletter">
                <p>Subscribe for gardening tips and latest kit updates.</p>
                <form>
                  <input
                    className="form-control"
                    type="email"
                    placeholder="Enter your email"
                    aria-label="Email"
                  />
                  <button type="submit" className="btn btn-subscribe">Subscribe</button>
                </form>
              </div>
            </div>
          </div>

        </div>
      </div>

      {/* Footer Menu */}
      <div className="footer-menu-bar">
        <div className="container">
          <div className="footer-menu">
            <a href="#">Privacy Policy</a>
            <a href="#">Cookie Settings</a>
            <a href="#">Terms</a>
            <a href="#">Accessibility</a>
            <a href="#">Advertise</a>
            <a href="#">Contact</a>
          </div>
        </div>
      </div>

      {/* Footer Bottom */}
      <div className="footer-bottom">
        <div className="container">
          <div className="row">
            <div className="col-md-6">
              <p>&copy; {new Date().getFullYear()} Bhasaka Harvest. All rights reserved.</p>
            </div>
            <div className="col-md-6 text-md-end">
              <p>Powered by <a href="https://openai.com">OpenAI</a></p>
            </div>
          </div>
        </div>
      </div>
    </footer>
    
  )
}

export default MapTo('wknd-spa-react/components/footer') (Footer);
