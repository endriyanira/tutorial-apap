import React from "react";
// import classes from "./styles.module.css";

const Search = (props) => {
    return (
        
        <input className="form-control"
            type="search"
            placeholder={"Masukan Nama Barang"}
            onChange={props.handleChangeField}
        />
    );
}

export default Search;