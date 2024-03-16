import { Fragment } from "react";
import { Outlet } from "react-router-dom";
import MainHeader from "../MainHeader";
import { Link } from "react-router-dom";
const RootLayout = () => {
    return(
        <Fragment>
            <MainHeader />
            <Outlet/>
        </Fragment>
    );
}

export default RootLayout;