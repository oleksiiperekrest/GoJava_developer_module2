select
    d.id,
    d.first_name,
    d.last_name,
    d.salary,
    s.id as s_id,
    s.description as s_description,
    p.id as p_id,
    p.cost as p_cost,
    p.name as p_name,
    p.description as p_description,
    c.id as c_id,
    c.name as c_name,
    c.description as c_descrition,
    c.country as c_country
from
developers d, skills s, projects p, companies c,
developers_companies dc, developers_skills ds, projects_developers pd
where
d.id = dc.developer_id and dc.company_id = c.id and
d.id = ds.developer_id and ds.skill_id = s.id and
d.id = pd.developer_id and pd.project_id = p.id and
d.id = 1