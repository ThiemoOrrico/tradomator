import {CContainer, CNavbar, CNavbarBrand} from "@coreui/react";


export default function NavigationTop() {
    return (

    <CNavbar colorScheme="light" className="bg-light">
          <CContainer fluid>
        <CNavbarBrand href="#">
         <img
          src="/images/brand/coreui-signet.svg"
            alt=""
            width="22"
            height="24"
            className="d-inline-block align-top"
          />{' '}
          CoreUI
        </CNavbarBrand>
      </CContainer>
    </CNavbar>
)

}