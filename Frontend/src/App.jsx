import { useEffect, useState } from "react"
import './App.css'

const END_POINT_FILM = 'http://localhost:4000/film/';

export function App(){

    const [endpoint, setEndpoint] = useState(END_POINT_FILM);

    const [findTitle, setFindTitle] = useState(false);
    const [findYear, setFindYear] = useState(false);
    const [op, setOp] = useState(false);
    
    const [data, Setdata] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    useEffect(() => {
        setLoading(true);
        fetch(endpoint)
        .then(res => res.json())
        .then(data => Setdata(data))
        .catch(error => setError("Error al obtener los datos"))
        .finally(() => setLoading(false));
    },[endpoint]);

    const handleSearch = (e) => {
        e.preventDefault();
        let endpoint = END_POINT_FILM + "?";
        if(findTitle) { endpoint += "title=" + document.getElementById('textInputTitle').value; }
        if(findYear) {
            endpoint += "&year=" + document.getElementById('textInputYear').value;
            if(op){ endpoint += "&op=" + document.getElementById('opciones'); }
        }
        setEndpoint(endpoint);
        setError(null);
    };

    const handleCheckboxChangeTitle = () => {
        setFindTitle(!findTitle);
    };

    const handleCheckboxChangeYear = () => {
        setFindYear(!findYear);
    };

    const handleCheckboxChangeOp = () => {
        setOp(document.getElementById('opciones').value != "None");
    };
    
    return(
        <main>
            <section className="title">
                <h1>Star War Films</h1>
            </section>
            <section className="finder">
                <form>
                    <div className="form-div">
                        <label>
                            <input
                                type="checkbox"
                                name="option"
                                value="title"
                                onChange={handleCheckboxChangeTitle}
                            />
                            Title
                        </label> 
                        { findTitle &&
                        <input 
                            type="text" 
                            id="textInputTitle" 
                            placeholder="Title"
                        />      
                        }                
                    </div>
                    <div className="form-div">
                        <label>
                            <input
                                type="checkbox"
                                name="option"
                                value="year"
                                onChange={handleCheckboxChangeYear}
                            />
                            Year
                            { findYear &&
                            <select id="opciones" name="op" onChange={handleCheckboxChangeOp}>
                                <option value="None">None</option>
                                <option value="GT">GT</option>
                                <option value="GTE">GTE</option>
                                <option value="LT">LT</option>
                                <option value="LTE">LTE</option>
                            </select>
                            }
                        </label> 
                        { findYear &&
                        <input 
                            type="text" 
                            id="textInputYear" 
                            placeholder="Year" 
                        />      
                        }                 
                    </div>
                    <button onClick={handleSearch} >Search</button>  
                </form>  
            </section> 
            <section className="result">
                {
                    loading && 
                    <h1>Loading...</h1>
                }
                
                { !loading &&data  &&<table>
                    <thead>
                         <tr>
                            <th>imdbID</th>
                            <th>title</th>
                            <th>year</th>
                            <th>plot</th>
                        </tr>
                    </thead>
                    <tbody>
                        {data.map((item, index) => (
                        <tr key={index}>
                            <td>{item.imdbID}</td>
                            <td>{item.title}</td>
                            <td>{item.year}</td>
                            <td>{item.plot}</td>
                        </tr>
                        ))}
                    </tbody> 
                </table>
                }
            </section>
        </main>

    )
}