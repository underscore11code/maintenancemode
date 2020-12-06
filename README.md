# Maintenance Mode
A dirt simple plugin to allow only those with a permission on during maintenance.

## Commands
*`/mm` will also work*

* `/maintenancemode on` - Turn Maintenance Mode on

* `/maintenancemode off` - Turn Maintenance Mode off

* `/maintenancemode reload` - Reload from config

## Config

* `enabled: ` `true | false` - Whether maintenance mode is enabled

* `kickMessage:` `<string>` - Message to kick those without perms with

## Permissions

* `maintenancemode.bypass` - Allow a user to join during maintenance

* `maintenancemode.command` - Allow a user to use the `/maintenancemode` command