import {CFooter, CLink} from "@coreui/react";

export default function FooterNavigation() {

  return(
    <CFooter>
        <div>
            <CLink href="https://coreui.io">CoreUI</CLink>
            <span>&copy; 2021 creativeLabs.</span>
        </div>
        <div>
            <span>Powered by</span>
            <CLink href="https://coreui.io">CoreUI</CLink>
        </div>
    </CFooter>
  )
}