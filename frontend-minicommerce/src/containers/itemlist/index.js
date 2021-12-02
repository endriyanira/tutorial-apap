import React, { Component } from "react";
import Item from "../../components/Item";
import Search from "../../components/search";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/button";
import Modal from "../../components/modal";
// import Badge from "@material-ui/core/Badge";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import { Fab } from "@material-ui/core";
// import ViewStreamIcon from '@mui/icons-material/ViewStream';
import List from "../../components/List/index";

class ItemList extends Component{
    constructor(props){
        super(props);
        this.state = {
            items:[],
            shopItems: [],
            cartItems: [],
            cartHidden: true,
            isLoading: false,
            isCreate: false,
            isEdit: false,
            isSearch: false,
            stok:0,
            id: "",
            title: "",
            price: 0,
            description: "",
            category: "",
            quantity: 0
        };
        this.handleAddItem = this.handleAddItem.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleChangeField = this.handleChangeField.bind(this);
        this.loadData  = this.loadData.bind(this);
        this.handleSubmitItem = this.handleSubmitItem.bind(this);
        this.handleSubmitEditItem = this.handleSubmitEditItem.bind(this);
        this.cariSubmitItem = this.cariSubmitItem.bind(this);
        this.handleSearchButton = this.handleSearchButton.bind(this);
        this.handleSubmitDeleteItem = this.handleSubmitDeleteItem.bind(this);
        this.handleAddItemToCart = this.handleAddItemToCart.bind(this);
        
    }
    componentDidMount() {
       this.loadData();
    }

    handleCancel(event) {
        event.preventDefault();
        this.setState({ isCreate:false, isEdit: false, isSearch:false });
    }

    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }

    async loadData(){
        try {
            const { data } = await APIConfig.get("/item");
            this.setState({ items: data.result });
            } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
            }
    }

    handleAddItem() {
        this.setState({ isCreate:true });
    }

    async handleSubmitItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.post("/item", data);
            this.setState({
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
            } catch (error) {
                alert("Oops terjadi masalah pada server");
                console.log(error);
        }
        this.handleCancel(event);
    }

    handleEditItem(item) {
        this.setState({
            isEdit: true,
            id: item.id,
            title: item.title,
            price: item.price,
            description: item.description,
            category: item.category,
            quantity: item.quantity
        })
    }

    async handleSubmitEditItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.put(`/item/${this.state.id}`, data);
            this.setState({
                id: "",
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
            } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);   
    }
    
    async cariSubmitItem(text){
        if(text === "") this.loadData();
        else{
            const results = this.state.items.filter(item => {
                return item.title.toLowerCase().includes(text.toLowerCase())
            })
            this.setState({input : text});
            this.setState({ items : results})
        }

    }

    async handleSubmitDeleteItem(id) {
        try {
            await APIConfig.delete(`/item/${id}`);
            this.loadData()
        } catch (error) {
        alert("Oops terjadi masalah pada server");
            console.log(error);
        }

    }

    async handleSearchButton(nama) {
        if(nama === "") this.loadData();
        else{
            const availableItems = this.state.items.filter(item => {
                return item.title.toLowerCase().includes(nama.toLowerCase())
            })
            this.setState({input : nama})
            this.setState({ items : availableItems })
        }
    }


    handleToggle = () => {
        const cartHidden = this.state.cartHidden;
        this.setState({ cartHidden: !cartHidden });
    };



    handleMelebihiStokItem =  (qty) => {
        this.state.quantity -= qty;
        if(this.state.quantity < 0){
            alert("Stok tidak memenuhi!");
            this.state.quantity += qty;
            return false;
        }
        return true;
    }

    // updateShopItem = (item, inCart) => {
    //     const tempShopItems = this.state.shopItems;
    //     const targetInd = tempShopItems.findIndex((it) => it.id === item.id);
    //     tempShopItems[targetInd].inCart = inCart;
    //     this.setState({ shopItems: tempShopItems });
    // };
    

    handleAddItemToCart(item){
        console.log(item);
        console.log("item");
        const stokCukup = this.handleMelebihiStokItem(item.quantity);
            if(stokCukup === true) {
                const newItems = [...this.state.cartItems];
                const newItem = { ...item };
                const targetInd = newItems.findIndex((it) => it.id === newItem.id);
                if (targetInd < 0) {
                    newItem.inCart = true;
                    newItems.push(newItem);
                    // this.updateShopItem(newItem, true);
                }
            this.setState({ cartItems: newItems });
        }
    }
    



render() {

    return(
        <div className={classes.itemList}>
            <div style={{ position: "fixed", top: 25, right: 25 }}>
                <Fab variant="extended" onClick={this.handleToggle}>
                        <ShoppingCartIcon />
                </Fab>
            </div>
            <br>
            </br>
            <div className="container pt-3">
                <div className="row mt-3">
                {!this.state.cartHidden ? (
                    <div className="col-sm">
                    <h1 className={classes.title}>Cart Items</h1>
                        <List
                        className="text-center"
                        items={this.state.cartItems}
                        onItemClick={this.handleDeleteItemFromCart}
                        ></List>
                    </div>
                    ) : (
                        <div className="col-sm">
                            <h1 className={classes.title}>All Items</h1>
                            <div className="card">
                            <Search handleChangeField={(e) => this.handleSearchButton(e.target.value)}></Search>
                            </div>
                                <button className={classes.buttonAdd}
                                    onClick={this.handleAddItem}>
                                    Add-Item
                                </button>
                               
                            {this.state.items.map((item) => (
                                <Item
                                key={item.id}
                                id={item.id}
                                title={item.title}
                                price={item.price}
                                description={item.description}
                                category={item.category}
                                quantity={item.quantity}
                                handleEdit={ () => this.handleEditItem(item)}
                                handleDelete={() => this.handleSubmitDeleteItem(item.id)}
                                handleAddToCart={() => this.handleAddItemToCart(item.stok)}
                                />
                            ))}
                        </div>
                    )}
                </div>
            </div>
            <Modal
                show={this.state.isCreate || this.state.isEdit}
                handleCloseModal={this.handleCancel}
                modalTitle={this.state.isCreate
                    ?"Add Item"
                    : `Edit Item ID ${this.state.id}`}
            >
                <form>
                    <input
                    className={classes.textField}
                    type="text"
                    placehorder="Nama Item"
                    name="title"
                    value={this.state.title}
                    onChange={this.handleChangeField}
                    />
                    <input
                    className={classes.textField}
                    type="number"
                    placeholder="Harga"
                    name="price"
                    value={this.state.price}
                    onChange={this.handleChangeField}
                    />
                    <input
                    className={classes.textField}
                    placeholder="Deskripsi"
                    name="description"
                    rows="4"
                    value={this.state.description}
                    onChange={this.handleChangeField}
                    />
                    <input
                    className={classes.textField}
                    type="text"
                    placeholder="Kategori"
                    name="category"
                    value={this.state.category}
                    onChange={this.handleChangeField}
                    />
                    <input
                    className={classes.textField}
                    type="number"
                    placeholder="qty"
                    name="quantity"
                    value={this.state.quantity}
                    onChange={this.handleChangeField}
                    />
                    <Button action={this.state.isCreate
                        ? this.handleSubmitItem
                        : this.handleSubmitEditItem}
                    >
                        Create
                    </Button>
                    <Button action={this.handleCancel}>
                        Cancel
                    </Button>
                </form>
            </Modal>
        </div>
    );
}

    
}

export default ItemList;